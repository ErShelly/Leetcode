package lld;

public class RoleBasedAccess {
    public static void main(String[] args) {
        User admin = new User("Alice", RoleType.ADMIN);
        User user = new User("Bob", RoleType.USER);
        User guest = new User("Charlie", RoleType.GUEST);

        admin.performAction();
        user.performAction();
        guest.performAction();

        // Access Control Testing
        AccessControl ac = AccessControl.getInstance();
        System.out.println("Can Bob (USER) access ADMIN resources? " + ac.hasAccess(user, RoleType.ADMIN));
        System.out.println("Can Alice (ADMIN) access USER resources? " + ac.hasAccess(admin, RoleType.USER));
    }
}

// Step 1: Define an Enum for Roles
enum RoleType {
    ADMIN, USER, GUEST
}

// Step 2: lld.Role Interface
interface Role {
    void accessResource();
}

// Step 3: Concrete lld.Role Implementations
class AdminRole implements Role {
    public void accessResource() {
        System.out.println("Admin: Full Access");
    }
}

class UserRole implements Role {
    public void accessResource() {
        System.out.println("lld.User: Limited Access");
    }
}

class GuestRole implements Role {
    public void accessResource() {
        System.out.println("Guest: Read-Only Access");
    }
}

// Step 4: lld.Role Factory using Enum
class RoleFactory {
    public static Role getRole(RoleType roleType) {
        switch (roleType) {
            case ADMIN:
                return new AdminRole();
            case USER:
                return new UserRole();
            case GUEST:
                return new GuestRole();
            default:
                throw new IllegalArgumentException("Invalid lld.Role Type");
        }
    }
}

// Step 5: lld.User Class
class User {
    private String name;
    private RoleType roleType;
    private Role role;

    public User(String name, RoleType roleType) {
        this.name = name;
        this.roleType = roleType;
        this.role = RoleFactory.getRole(roleType);
    }

    public void performAction() {
        System.out.print(name + " (" + roleType + ") has ");
        role.accessResource();
    }

    public RoleType getRoleType() {
        return roleType;
    }
}

// Step 6: Singleton Access Control
class AccessControl {
    private static AccessControl instance;

    private AccessControl() {}

    public static synchronized AccessControl getInstance() {
        if (instance == null) {
            instance = new AccessControl();
        }
        return instance;
    }

    public boolean hasAccess(User user, RoleType requiredRole) {
        return user.getRoleType().ordinal() <= requiredRole.ordinal();
    }
}


