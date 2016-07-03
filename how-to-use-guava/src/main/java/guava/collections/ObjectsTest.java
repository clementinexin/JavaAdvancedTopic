package guava.collections;

import com.google.common.collect.ComparisonChain;

/**
 * Created by daijiajia on 16/7/3.
 */
public class ObjectsTest {

    static class Name implements Comparable {
        String firstName;
        String middleName;
        String lastName;

        public Name(String middleName, String firstName, String lastName) {
            this.middleName = middleName;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Object o) {
            o = (Name) o;

            return ComparisonChain.start()
                    .compare(this.firstName, ((Name) o).firstName)
                    .compare(this.middleName, ((Name) o).middleName)
                    .compare(this.lastName, ((Name) o).lastName)
                    .result();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Name name = (Name) o;

            if (firstName != null ? !firstName.equals(name.firstName) : name.firstName != null) return false;
            if (middleName != null ? !middleName.equals(name.middleName) : name.middleName != null) return false;
            return lastName != null ? lastName.equals(name.lastName) : name.lastName == null;

        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        Name name1 = new Name("A", "B", "C");
        Name name2 = new Name("A", "B", "C1");
        System.out.println(name1.compareTo(name2));
    }
}
