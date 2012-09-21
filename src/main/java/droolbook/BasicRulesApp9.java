package droolbook;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.joda.time.DateTime;

public class BasicRulesApp9 {

  public static final void main(String[] args) {
    KnowledgeBase knowledgeBase = createKnowledgeBase();
    StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
    try {
   
      session.insert(new DateTime());

      session.fireAllRules();

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
    builder.add(ResourceFactory.newClassPathResource("droolbook/basic9.drl"), ResourceType.DRL);
    if (builder.hasErrors()) {
      throw new RuntimeException(builder.getErrors().toString());
    }
    KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
    return knowledgeBase;
  }
}
