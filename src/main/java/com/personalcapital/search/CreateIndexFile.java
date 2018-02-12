package com.personalcapital.search;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class CreateIndexFile {
	public static void main(String[] args) throws Exception{

        //Provide the location of the destination file


        Class.forName("org.relique.jdbc.csv.CsvDriver");

        // Create a connection. The first command line parameter is
        // the directory containing the .csv files.
        // A single connection is thread-safe for use by several threads.
        Connection	 conn = DriverManager.getConnection("jdbc:relique:csv:" + "/Users/sharatjagannath/Downloads/F_5500_2016_Latest");	//Source CSV file

        // Create a Statement object to execute the query with.
        Statement stmt = conn.createStatement();
        String query= "SELECT * FROM csvdata";					//csvdata is the source file

        // Select the ID and NAME columns from csvdata.csv
        ResultSet results = stmt.executeQuery(query);
        ResultSetMetaData metadata = results.getMetaData();
        int numColumns = metadata.getColumnCount();
        int count=1;
        String FILENAME1 = "/Users/sharatjagannath/Downloads/data"+count+".json";
        File file1 = new File(FILENAME1);

        FileWriter writer=new FileWriter(file1, true);
        while(results.next())             //iterate rows
        {
            if(count%100==0){
                 FILENAME1 = "/Users/sharatjagannath/Downloads/data"+count+".json";
                 file1 = new File(FILENAME1);
                writer.flush();
                writer = new FileWriter(file1, true);
            }
            JSONObject obj = new JSONObject();      //extends HashMap
            for (int i = 1; i <= numColumns; ++i)           //iterate columns
            {
                String column_name = metadata.getColumnName(i);
                obj.put(column_name, results.getObject(column_name));
            }

            writer.write("{ \"index\" : { \"_index\": \"plans\", \"_type\" : \"listings\", \"_id\" : \""+count+"\" } }\n");
            writer.write(obj.toString());
            writer.write("\n");

            count++;
        }
        // Clean up
        conn.close();
    }
}
