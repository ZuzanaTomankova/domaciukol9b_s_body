package com.engeto.domaciukol9b.service;

import com.engeto.domaciukol9b.model.User;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ContributionService {

    public void saveToFile(List<User> users) throws RuntimeException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("userData")))) {
            for (User user : users) {
                writer.println(user.getContribution() + "\t"
                        + user.getContributionId() + "\t"
                        + user.getIsVisible() + "\t"
                        + user.getUser() + "\t");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Soubor nebyl nalezen!\n"
                    + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException("Chyba výstupu při zápisu do souboru. "
                    + ":\n" + e.getLocalizedMessage());
        }

    }
}
