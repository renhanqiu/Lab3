package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import exception.CommondException;

public class LoggerHelper {
	static public void findLog(String filePath, Scanner scan) throws CommondException {
		List<String> logger = new ArrayList<>();
		String line = "", command = "";
		try {
			File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
            	logger.add(line);
            }
            br.close();
		} catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("1.time\t2.class\t3.method\t4.type\t5.operate");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.print("start:");
			scan.nextLine();
			String start = scan.nextLine();
			System.out.print("end:");
			String end = scan.nextLine();
			try {
				Date d1 = sdf.parse(start);
				Date d2 = sdf.parse(end);
				for (String log: logger) {
					String[] data = log.split("Time: |]");
					Date date = sdf.parse(data[1]);
					if (date.before(d2) && date.after(d1)) System.out.println(log);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.print("class:");
			scan.nextLine();
			command = scan.nextLine();
			for (String log: logger)
				if (log.contains(command)) System.out.println(log);
			break;
		case 3:
			System.out.print("method:");
			scan.nextLine();
			command = scan.nextLine();
			for (String log: logger)
				if (log.contains(command)) System.out.println(log);
			break;
		case 4:
			System.out.print("type:");
			scan.nextLine();
			command = scan.nextLine();
			for (String log: logger)
				if (log.toLowerCase().contains(command)) System.out.println(log);
			break;
		case 5:
			System.out.print("operate:");
			scan.nextLine();
			command = scan.nextLine();
			for (String log: logger)
				if (log.toLowerCase().contains(command)) System.out.println(log);
			break;
		default :
			throw new CommondException("Wrong choice");
		}
	}
}
