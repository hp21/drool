package droolbook;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Account {
  
  private long balance;

  public Account() {
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other)
      return true;
    if (!(other instanceof Account))
      return false;
    Account castOther = (Account) other;
    return new EqualsBuilder().append(balance, castOther.balance).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(1450207409, -1692382659).append(balance).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("balance", balance).toString();
  }
}