package com.t2dev.repo2;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearch;
    private Button btnSearch;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private ArrayList<ResultModel> resultModels;
    private ResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.et_search);
        btnSearch = findViewById(R.id.btn_search);
        recyclerView = findViewById(R.id.recycler_view);
        requestQueue = Volley.newRequestQueue(this);
        resultModels = new ArrayList<>();

        resultAdapter = new ResultAdapter(resultModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        recyclerView.setAdapter(resultAdapter);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = etSearch.getText().toString().trim();
                if (!TextUtils.isEmpty(searchTerm)) {
                    fetchDataFromAPI(searchTerm);
                } else {
                    Toast.makeText(SearchActivity.this, "Enter Search Query", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchDataFromAPI(String searchTerm) {
        String url = "https://script.google.com/macros/s/AKfycbx3kBWkzctoDnEt8bTTz4ydzLWX2LD9e_2vfBy6Ces6eGPR9jgsLBF4HOka2vVls7NP/exec?searchTerm=" + searchTerm;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject result = response.getJSONObject(i);
                            Log.e("response",response.toString());

                            String column1 = result.getString("column1");
                            String column2 = result.getString("column2");
                            String column3 = result.getString("column3");
                            String column4 = result.getString("column4");
                            String column5 = result.getString("column5");
                            String column6 = result.getString("column6");
                            String column7 = result.getString("column7");
                            String column8 = result.getString("column8");
                            String column9 = result.getString("column9");
                            String column10 = result.getString("column10");
                            String column11 = result.getString("column11");
                            String column12 = result.getString("column12");
                            String column13 = result.getString("column13");
                            String column14 = result.getString("column14");
                            String column15 = result.getString("column15");
                            String column16 = result.getString("column16");
                            resultModels.add(new ResultModel(column1, column2, column3, column4, column5,
                                    column6, column7, column8, column9, column10, column11, column12,
                                    column13, column14, column15, column16));
                        }
                        resultAdapter.notifyDataSetChanged();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);
    }

}


