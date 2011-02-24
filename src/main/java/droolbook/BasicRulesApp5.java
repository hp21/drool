package droolbook;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.joda.time.DateTime;

public class BasicRulesApp5 {

  public static final void main(String[] args) {
    KnowledgeBase knowledgeBase = createKnowledgeBase();
    StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
    try {
      Account account = new Account();
      account.setBalance(50);
      session.insert(account);

      account = new Account();
      account.setBalance(51);
      session.insert(account);

      account = new Account();
      account.setBalance(150);
      session.insert(account);

      account = new Account();
      account.setBalance(250);
      session.insert(account);

      account = new Account();
      account.setBalance(100);
      session.insert(account);

      session.insert("asdasd");
      session.insert(new DateTime());

      session.fireAllRules();

      account = new Account();
      account.setBalance(1000);
      session.insert(account);

      Customer customer = new Customer();
      customer.setName("John");
      session.insert(customer);
      session.fireAllRules();

    } finally {
      session.dispose();
    }
  }

  private static KnowledgeBase createKnowledgeBase() {
    KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    builder.add(ResourceFactory.newClassPathResource("droolbook/basic5.drl"), ResourceType.DRL);
    if (builder.hasErrors()) {
      throw new RuntimeException(builder.getErrors().toString());
    }
    KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
    return knowledgeBase;
  }
}
