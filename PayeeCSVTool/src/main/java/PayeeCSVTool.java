import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PayeeCSVTool {


    public static void main(String[] args) throws IOException {

        String type = "Individual";
        String remoteID = "remoteId";

        String emailAddress = "@velopayments.com";
        String address = "Address 1";
        String addressCity = "the city";
        String addressCounty = "orange";
        String zip = "123456";
        String addressCountry = "United States";
        String individualDateOfBirth = "1970-12-12";
        String firstName = "payee";
        String lastName = "lastName";
        String ssn = "123456789";
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        



        System.out.println("Welcome to the Velo payee tool. You will need a CSV to edit and a path to reach it");
        System.out.println("How many payees would you like to make?");
        int i = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the local-part of your email?");
        String email = scanner.next();
        System.out.println("What is the path to the CSV you would like to edit");
        String csv = scanner.next();



        // Create file writer
        FileWriter outputfile = new FileWriter(csv);

        CSVWriter writer = new CSVWriter(outputfile,
                CSVWriter.DEFAULT_SEPARATOR);


        // Create header
        String[] header = new String [] {"type", "remoteId", "email", "addressLine1", "addressLine2", "addressLine3", "addressLine4",
                "addressCity", "addressCountyOrProvince", "addressZipOrPostcode", "addressCountry",	"individualNationalIdentification",
                "individualDateOfBirth", "individualTitle", "individualFirstName", "individualOtherNames", "individualLastName",
                "companyName", "companyEIN	paymentChannelIban", "paymentChannelAccountNumber",	"paymentChannelRoutingNumber",
                "paymentChannelAccountName", "paymentChannelCountryCode", "paymentChannelCurrency",	"challengeDescription",	"challengeValue"};
        writer.writeNext(header);

        // Create Body
        List<String[]> allData = new ArrayList<String[]>();
        for (int j=0; j<i; j++ ) {
            int n = rand.nextInt(100000) + 1;
            String[] data = new String[]{ type, remoteID+n, email + "+" + n + emailAddress, address,"","","", addressCity, addressCounty, zip, addressCountry, ssn, individualDateOfBirth, "", firstName,
                    "", lastName+n, "", "", "", "", "", "", "", "", ""};
            allData.add(data);
        }
        //WriteAll to main list
        writer.writeAll(allData);
        //close
        writer.close();


    }
}
