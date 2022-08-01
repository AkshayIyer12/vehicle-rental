package com.example.vehiclerental;


import com.example.vehiclerental.service.RentalService;
import com.example.vehiclerental.util.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.example.vehiclerental.util.utility.log;

public class VehicleRentalApplication {

	public static void main(String[] args) {
		Scanner sc = null;
		List<String> arr = new ArrayList<String>();
		RentalService rs = new RentalService();
		try {
			if (utility.isNotEmpty(args[0])) {
				String file = args[0];
				sc = new Scanner(new File(file));
				sc.useDelimiter("\n");
				while(sc.hasNextLine()) {
					String entry = sc.nextLine();
					if (entry != null && entry.length() != 0) {
						entry = entry.trim();
						rs.process(entry);
					}
				}
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception ex) {
				log(ex.getMessage());
			}
		}

	}

}
