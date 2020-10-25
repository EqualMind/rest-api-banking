package com.example.banking;

import com.example.banking.entities.Account;
import com.example.banking.entities.Balance;
import com.example.banking.repositories.AccountRepository;
import com.example.banking.repositories.BalanceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BankingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    /** Заполнение базы данных тестовыми данными. */
    @Bean
    public CommandLineRunner fillData(AccountRepository accounts, BalanceRepository balances) {
        return (args) -> {
            var smithAccount = new Account("John Smith");
            var greenAccount = new Account("Richard Green");
            var waltonAccount = new Account("Jack Walton");

            accounts.save(smithAccount);
            accounts.save(greenAccount);
            accounts.save(waltonAccount);

            balances.save(new Balance(smithAccount, new BigDecimal("100000.0")));
            balances.save(new Balance(greenAccount, new BigDecimal("50000.0")));
            balances.save(new Balance(greenAccount, new BigDecimal("1000.0")));
            balances.save(new Balance(waltonAccount, new BigDecimal("100.0")));
        };
    }
}
