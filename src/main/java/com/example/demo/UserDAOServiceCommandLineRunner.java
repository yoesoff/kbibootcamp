package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskDAOService;
import com.example.demo.service.UserDAOService;
import com.example.demo.service.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * UserDAOServiceCommandLineRunner
 */
@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;

    @Autowired
    private TaskDAOService taskDAOService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        LocalDateTime now = LocalDateTime.now();  

        User user = new User("Joni", "Coder", (float) 9887.8, now);
        Task task = new Task("Koding dengan sabar.", now, false, user);
        task.setUser(user);
        userDAOService.insert(user);
        taskDAOService.insert(task);

        User user1 = new User("kukuh", "Designer", (float) 9987.8, now);
        Task task1 = new Task("Mendesign dengan bahagia.", now, false, user1);
        task1.setUser(user1);
        userDAOService.insert(user1);
        taskDAOService.insert(task1);

        User user2 = new User("merry", "Analyst", (float) 9187.8, now);
        Task task2 = new Task("Minum juss kentang", now, false, user2);
        task2.setUser(user2);
        userDAOService.insert(user2);
        taskDAOService.insert(task2);

        // 1. Dapatkan first User 
        Optional<User> firstUser = userRepo.findById(1);

        if (firstUser.isPresent()) {
            System.out.println(firstUser.get().getId());
        }

        // 2. Find user yang salarynya lebih dari X
        List<User> greaterSalary = userRepo.findBySalaryGreaterThan(2000);
        System.out.println("Greater than 2000: " + greaterSalary.size() + "Users");


        // 3. Tambahkan query baru di UserRepository untuk mencari 
        Date date = new Date();
        String strStart = sdf.format(date) + " 00:00:00";
        String strEnd = sdf.format(date) + " 23:59:59";

        LocalDateTime dateStart = LocalDateTime.parse(strStart, dtf);
        LocalDateTime dateEnd = LocalDateTime.parse(strEnd, dtf);

        List<User> loginToday = userRepo.findByLastLoginBetween(dateStart, dateEnd);
        System.out.println("Login Today: " + loginToday.size() + "Users");

        // 4. User tanpa tasks
        List<User> withoutTasks = userRepo.findByTasksIsEmpty();
        System.out.println("Without task(s): " + withoutTasks.size() + "Users");
    }
}