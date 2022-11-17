import com.Dao.AdmincDao;
import com.Dao.UserDao;
import com.model.Stock;
import com.model.Users;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) throws Exception {

        AdmincDao dao = new AdmincDao();
        List<Stock> listA = dao.getAllStock();
        /*UserDao userDao=new UserDao();*/
        int id_user=36;
        AdmincDao admincDao=new AdmincDao();
        Users users=admincDao.getuser(id_user);
        List<Stock>  listB = listA.stream()
                .filter(x -> x.getUsersByIdUsers().equals(users))
                .collect(Collectors.toList());
        for(Stock v : listB) {
            System.out.println(v.getCategorie());
            System.out.println(v.getProduit());
            System.out.println(v.getPrix());
            System.out.println(v.getQuantites());
            }
    }
}