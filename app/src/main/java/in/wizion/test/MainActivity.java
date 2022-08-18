package in.wizion.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String sortedlist ="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText e1 = findViewById(R.id.listA);
        EditText e2 = findViewById(R.id.listB);
        Button btn = findViewById(R.id.btn);
        Button btnClear = findViewById(R.id.btnClear);
        TextView view = findViewById(R.id.sortedlist);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.getText().clear();
                e2.getText().clear();
                view.setText("");
                sortedlist = "";

            }
        });

        btn.setOnClickListener(v -> {

            //To get text from Edittext
            String str1 = e1.getText().toString();
            String str2 = e2.getText().toString();

            if (str1.isEmpty()){
                e1.setError("Please Enter the Elements");
            }else if(str2.isEmpty()){
                e2.setError("Please Enter the Elements");
            }else {

                //create integer arrayList1 from Edittext
                String[] arrStr1 = str1.split(",");
                ArrayList<Integer> arr1 = new ArrayList<Integer>();
                for (String item :  arrStr1) {
                    arr1.add(Integer.parseInt(item));
                }

                //create integer arrayList2 from Edittext
                String[] arrStr2 = str2.split(",");
                ArrayList<Integer> arr2 = new ArrayList<Integer>();
                for (String item :  arrStr2) {
                    arr2.add(Integer.parseInt(item));
                }

                //merge and short arraylist1 and arraylist2
                //and returned arraylist convert into string to show into textview
                ArrayList<Integer> mergeAndSortList = MergeAndSort(arr1,arr2);
                for (Integer item :  mergeAndSortList) {
                    sortedlist += item+" , ";
                }

                //sorted list shown in textview
                view.setText("Sorted list Is : " + sortedlist);
            }
        });

    }

    //while loop is used which have O(n) time complexity
     private ArrayList<Integer> MergeAndSort(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        int i = 0 ;
        int j = 0 ;

        while (i < a.size() && j<b.size()){
            if (a.get(i) < b.get(j)){
                res.add(a.get(i));
                i++;
            }else {
                res.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()){
            res.add(a.get(i));
            i++;
        }

        while (j < b.size()){
            res.add(b.get(j));
            j++;
        }

        return  res;
    }

}








