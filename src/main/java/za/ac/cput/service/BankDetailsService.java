package za.ac.cput.service;

import za.ac.cput.domain.BankDetails;
import java.util.List;

public interface BankDetailsService {
    BankDetails create(BankDetails bankDetails);
    BankDetails read(String id);
    BankDetails update(BankDetails bankDetails);
    boolean delete(String id);
    List<BankDetails> getAll();
}
