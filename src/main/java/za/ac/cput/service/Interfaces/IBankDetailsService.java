package za.ac.cput.service.Interfaces;

import za.ac.cput.domain.BankDetails;
import java.util.List;

public interface IBankDetailsService extends IService<BankDetails, Long> {
    List<BankDetails> getAll();
}
