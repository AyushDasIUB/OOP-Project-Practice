
package mainpkg;

/**
 *
 * @author dasay
 */
public class User {
    protected String name;
    protected int id;
    protected String category;
    protected String password;

    public User() {
    }

    public User(String name, int id, String category, String password) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", category=" + category + ", password=" + password + '}';
    }




    
}
