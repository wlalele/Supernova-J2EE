package Bank.controllers;

/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2012 Sun Microsystems, Inc.
 */

import Bank.classes.Account;
import Bank.dao.AccountDao;
import Bank.classes.AccountLine;
import Bank.dao.AccountLineDao;
import Bank.classes.Client;
import Bank.dao.ClientDao;
import Bank.classes.SavingsAccount;
import java.io.Serializable;
import java.util.Date;

import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author dev
 */
@Named("gestionClient")
@ManagedBean
public class GestionClient implements Serializable {
    
    @EJB
    private ClientDao client_dao;
    @EJB
    private AccountDao account_dao;
    @EJB
    private AccountLineDao account_line_dao;
    
    private StringBuilder out = null;
    
    public GestionClient()
    {
        super();
    }

    public String getJpa()
    {
        this.out = new StringBuilder();
     
        // Création des clients, des comptes et des lignes de compte
        this.createClients();
        this.createAccounts();
        this.createAccountLines();
    
        // Affichage des clients, des comptes et des lignes de compte
        this.showClients();
        this.showAccounts();
        this.showAccountLines();
        
        // Test de la fonction de recherche par prénom
        this.searchTest();
        
        return this.out.toString();
    }
    
    private void createClients()
    {
        this.client_dao.create(Client.factory((long)12, "Grard", "Rhandy", "12 rue de la vigne", "59000", "Henin-Beaumont", "rgrard@gmail.com", "eCrkoRzz"));
        this.client_dao.create(Client.factory((long)13, "Dai", "Amine", "1 Bvd Liberté", "59370", "Mons-en-Baroeul", "adai@gmail.com", "azerty"));
    }
    
    private void showClients()
    {
        this.out.append("Recherche des clients<br>");    
        List<Client> clients = client_dao.findClients();
        Iterator<Client> it = clients.iterator();
        
        while (it.hasNext()) {
            this.out.append((it.next()).toString());
            this.out.append("<br>");
        }
        
        this.out.append("<br>");
    }
    
    private void createAccounts()
    {
        this.account_dao.create(Account.factory((long)365943352));
        this.account_dao.create(SavingsAccount.factorySavings((long)365943353, 0.5, SavingsAccount.SavingsAccountType.LIVRET_A));
    }
    
    private void showAccounts()
    {
        this.out.append("Recherche des comptes<br>");    
        List<Account> accounts = account_dao.findAccounts();
        Iterator<Account> it = accounts.iterator();
        
        while (it.hasNext()) {
            this.out.append((it.next()).toString());
            this.out.append("<br>");
        }
        
        this.out.append("<br>");
    }
    
    private void createAccountLines()
    {
        this.account_line_dao.create(AccountLine.factory("Retrait de cash", new Date(), new Date(), (float)156.9));
    }
    
    private void showAccountLines()
    {
        this.out.append("Recherche des lignes de compte<br>");    
        List<AccountLine> account_lines = account_line_dao.findAccountLines();
        Iterator<AccountLine> it = account_lines.iterator();
        
        while (it.hasNext()) {
            this.out.append((it.next()).toString());
            this.out.append("<br>");
        }
        
        this.out.append("<br>");
    }
    
    private void searchTest()
    {
        this.out.append("Recherche par prenom: <br>");
        Client client = client_dao.findClientByFirstname("Rhandy");
        this.out.append(client.toString());
        
        this.out.append("<br>");
        
        this.out.append("Recherche par nom: <br>");
        Client client2 = client_dao.findClientByLastname("Dai");
        this.out.append(client2.toString());
        
        this.out.append("<br>");
        
        this.out.append("Recherche par mail: <br>");
        Client client3 = client_dao.findClientByMail("rgrard@gmail.com");
        this.out.append(client3.toString());
    }
}