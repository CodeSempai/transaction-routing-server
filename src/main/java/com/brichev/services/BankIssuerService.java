package com.brichev.services;


import com.brichev.models.BankIssuer;
import com.brichev.models.BankIssuerBin;
import com.brichev.repositories.BankIssuerBinRepository;
import com.brichev.repositories.BankIssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankIssuerService {

    @Autowired
    private BankIssuerBinRepository bankIssuerBinRepository;

    @Autowired
    private BankIssuerRepository bankIssuerRepository;

    public void saveBankIssuerBin(BankIssuerBin bankIssuerBin) {
        BankIssuer bankIssuer = bankIssuerBin.getBankIssuer();
        List<BankIssuer> bankIssuerList = bankIssuerRepository.findByUrlAndAndTargetName(bankIssuer.getUrl(), bankIssuer.getTargetName());
        if (bankIssuerList.isEmpty()) {
            bankIssuerRepository.save(bankIssuerBin.getBankIssuer());
        } else {
            bankIssuerBin.setBankIssuer(bankIssuerList.get(0));
        }
        bankIssuerBinRepository.save(bankIssuerBin);
    }

    public void removeBankIssuerBin(BankIssuerBin bankIssuerBin) {
        bankIssuerBinRepository.removeById(bankIssuerBin.getId());
    }

    /*
    public void editBankIssuerBin(Integer id, BankIssuerBin bankIssuerBin){
        BankIssuerBin foundBankIssuerBin = bankIssuerBinRepository.findById(id).get();
        System.out.println(foundBankIssuerBin.getBin() + " " + bankIssuerBin.getBin());
       // foundBankIssuerBin.setBin(bankIssuerBin.getBin());
        //foundBankIssuerBin.setBankIssuer(bankIssuerBin.getBankIssuer());

    }
     */

    public Iterable<BankIssuerBin> getAllBins() {
        return bankIssuerBinRepository.findAll();
    }


}
