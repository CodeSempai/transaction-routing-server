package com.brichev.services;


import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.repositories.BankIssuerBinRepository;
import com.brichev.repositories.BankIssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankIssuerService {

    @Autowired
    private BankIssuerBinRepository bankIssuerBinRepository;

    @Autowired
    private BankIssuerRepository bankIssuerRepository;

    public void saveBankIssuerBin(BankIssuerBin bankIssuerBin) {
        BankIssuer bankIssuer = bankIssuerBin.getBankIssuer();
        List<BankIssuer> bankIssuerList = bankIssuerRepository
                .findByUrlAndAndTargetName(bankIssuer.getUrl(), bankIssuer.getTargetName());
        if (bankIssuerList.isEmpty()) {
            bankIssuerRepository.save(bankIssuerBin.getBankIssuer());
        } else {
            bankIssuerBin.setBankIssuer(bankIssuerList.get(0));
        }
        bankIssuerBinRepository.save(bankIssuerBin);
    }

    public void removeBankIssuerBin(BankIssuerBin bankIssuerBin) {
        removeBankIssuerBin(bankIssuerBin.getId());
    }

    private void removeBankIssuer(BankIssuer bankIssuer) {
        List<BankIssuerBin> bankIssuerBinList = bankIssuerBinRepository
                .findAllByBankIssuer(bankIssuer);
        if (bankIssuerBinList.size() == 0) {
            bankIssuerRepository.removeById(bankIssuer.getId());
        }
    }

    public void removeBankIssuerBin(Integer id) {
        Optional<BankIssuerBin> optional = bankIssuerBinRepository.findById(id);
        if (optional.isPresent()) {
            BankIssuerBin bankIssuerBin = optional.get();
            bankIssuerBinRepository.removeById(id);
            removeBankIssuer(bankIssuerBin.getBankIssuer());
        }

    }


    public void editBankIssuerBin(Integer id, BankIssuerBin bankIssuerBin) {
        Optional<BankIssuerBin> optional = bankIssuerBinRepository.findById(id);
        if (optional.isPresent()) {
            BankIssuerBin foundBankIssuerBin = optional.get();
            BankIssuer bankIssuer = bankIssuerBin.getBankIssuer();
            BankIssuer previousBankIssuer = foundBankIssuerBin.getBankIssuer();
            List<BankIssuer> bankIssuerList = bankIssuerRepository
                    .findByUrlAndAndTargetName(bankIssuer.getUrl(), bankIssuer.getTargetName());
            if (bankIssuerList.isEmpty()) {
                bankIssuerRepository.save(bankIssuerBin.getBankIssuer());
                foundBankIssuerBin.setBankIssuer(bankIssuerBin.getBankIssuer());
                removeBankIssuer(previousBankIssuer);
            } else {
                foundBankIssuerBin.setBankIssuer(bankIssuerList.get(0));
            }
            foundBankIssuerBin.setBin(bankIssuerBin.getBin());

        }
    }

    public BankIssuerBin getBinById(Integer id) {
        Optional<BankIssuerBin> optional = bankIssuerBinRepository.findById(id);
        assert (optional.isPresent());
        return optional.get();
    }

    public Iterable<BankIssuerBin> getAllBins() {
        return bankIssuerBinRepository.findAll();
    }

    public List<BankIssuerBin> getBinsList() {
        return new ArrayList<>(bankIssuerBinRepository.findAll());
    }

    public Long countByBin(String bin) {
        return bankIssuerBinRepository.countAllByBin(bin);
    }

}
