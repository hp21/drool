package droolbook;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Customer {

  private String name;
  private Account account;

  public Customer() {
  }

  public Customer(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account getAccount() {
    return account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Customer customer = (Customer) o;

    if (account != null ? !account.equals(customer.account) : customer.account != null)
      return false;
    if (name != null ? !name.equals(customer.name) : customer.name != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (account != null ? account.hashCode() : 0);
    return result;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", name).append("account", account).toString();
  }

}
