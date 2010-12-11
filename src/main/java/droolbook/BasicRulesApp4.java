package droolbook;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.joda.time.DateTime;

public class BasicRulesApp4 {

    public static final void main(String[] args) {
        KnowledgeBase knowledgeBase = createKnowledgeBase();
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        try {
            Account account = new Account();

            account = new Account();
            session.insert(account);

            account = new Account();
            account.setBalance(100);
            session.insert(account);

            session.insert("asdasd");
            session.insert(new DateTime());

            session.fireAllRules();

            account = new Account();
            account.setBalance(1000);
//            account.setBalance(99);
            session.insert(account);

            Customer customer = new Customer("Jane");
            customer.setAccount(account);
            session.insert(customer);

            customer = new Customer("John");
            customer.setAccount(account);
            session.insert(customer);

            session.fireAllRules();

        } finally {
            session.dispose();
        }
    }

    private static KnowledgeBase createKnowledgeBase() {
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        builder.add(ResourceFactory.newClassPathResource("droolbook/basic.drl"), ResourceType.DRL);
        builder.add(ResourceFactory.newClassPathResource("droolbook/basic4.drl"), ResourceType.DRL);
        if (builder.hasErrors()) {
            throw new RuntimeException(builder.getErrors().toString());
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
        return knowledgeBase;
    }
}
