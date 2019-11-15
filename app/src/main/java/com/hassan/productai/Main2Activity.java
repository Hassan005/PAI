package com.hassan.productai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {
TextView mydata;
    String easyPuzzle;
    private   String recognised_string;
    private final String blue_shirt = "https://gist.githubusercontent.com/Hassan005/ed149e50d3dab9ba3fa0b4cf4c0e67cf/raw/01560f27e064442d0b07b9900117f21616a74d30/blue_shirt.json" ;
    private final String computer_laptop ="https://gist.githubusercontent.com/Hassan005/760d6c70c7f5dc17909a6edcdd2eb437/raw/129458550f8ef1020cc3ce4e129721fb49c62205/computer_laptop.json";
    private final String mens_pants="https://gist.githubusercontent.com/Hassan005/ebf24dc75e2276eefd1a21d6c43e0b2a/raw/f72622c6c39faae5edee85725df2de0cca9a984f/mens_pants.json";
    private final String mens_shoes="https://gist.githubusercontent.com/Hassan005/2ba54f333b571a71b572177cdfb38cc7/raw/087492d3328f0bb6e5cee778606f3b4236d3085c/mens_shoes.json";
    private  final String mobile_phones="https://gist.githubusercontent.com/Hassan005/44ab28202bd11ce361c59208fc1ad839/raw/725a272fa833ee3fbaef2ee411a6c3de824dfe11/mobile_phones.json";
    private final String red_shirt="https://gist.githubusercontent.com/Hassan005/1f3aeabdcfa4b82dfb96d46c67fd32ef/raw/9146b8c20a07920c712bff88303267cb3a16cb87/red_shirt.json";
    private final String three_piece_dress="https://gist.githubusercontent.com/Hassan005/0d74350926e23a99ae2b922234d4b7ed/raw/f53525a574d7ee29a835e3e737a405bf788b084d/threepiece_dress.json";
    private JsonArrayRequest request ;

    private RequestQueue requestQueue ;
    private List<Products> istproductEbay ;
    private List<Products> istproductsAliExpress ;
    private RecyclerView recycler_view_Ebay ,recycler_view_ali_express;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydata=findViewById(R.id.textView2);
        Intent i = getIntent();
         recognised_string = i.getStringExtra("dat");
        mydata.setText(recognised_string);

        Toast.makeText(this,"We think it's : "+recognised_string,Toast.LENGTH_LONG).show();
        istproductEbay = new ArrayList<>() ;
        istproductsAliExpress=new ArrayList<>();
        recycler_view_Ebay = findViewById(R.id.ebayrecyclerview);
        recycler_view_ali_express=findViewById(R.id.recyclerviewidaliexpress);
        jsonrequest();

    }

    private void jsonrequest() {
        if (recognised_string.equals("blue shirt") || recognised_string.equals("shirt blue"))
        {
            request = new JsonArrayRequest(blue_shirt, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("blue shirt");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("blue shirt");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("Computer laptop") || recognised_string.equals("laptop Computer"))
        {
            request = new JsonArrayRequest(computer_laptop, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("Computer laptop");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("Computer laptop");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("mens pants") || recognised_string.equals("pants mens")){
            request = new JsonArrayRequest(mens_pants, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("mens pants");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("mens pants");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("mens shoes") || recognised_string.equals("shoes mens"))
        {
            request = new JsonArrayRequest(mens_shoes, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("mens shoes");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("mens shoes");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("ThreePiece Dress") || recognised_string.equals("Dress ThreePiece"))
        {
            request = new JsonArrayRequest(three_piece_dress, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("ThreePiece Dress");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("ThreePiece Dress");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("mobile phones") || recognised_string.equals("phones mobile"))
        {
            request = new JsonArrayRequest(mobile_phones, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("mobile phones");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("mobile phones");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }
        else if (recognised_string.equals("red shirt") || recognised_string.equals("shirt red"))
        {
            request = new JsonArrayRequest(red_shirt, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
//
                        JSONObject shirtObjEbay = response.getJSONObject(0);
                        JSONObject shirtObjAliExpress = response.getJSONObject(1);
//                    System.out.println("first elemrnt"+shirtObj);
//                    JSONObject shirtObjA=response.getJSONObject(1);
//                    System.out.println("Second elemrnt"+shirtObjA);
                        // Retrieves "colorArray" from the JSON object
                        JSONArray ShirtArrayEbay = shirtObjEbay.getJSONArray("red shirt");
                        JSONArray ShirtArrayAliExpress = shirtObjAliExpress.getJSONArray("red shirt");
//                    JSONArray shirtObjAraayali = shirtObjA.getJSONArray("blue shirt");
                        for (  int i = 0; i < ShirtArrayEbay.length(); i++) {


                            JSONObject jsonObject = ShirtArrayEbay.getJSONObject(i);

                            Products products = new Products();
                            products.setProduct_name(jsonObject.getString("Product name"));

                            products.setPrice(jsonObject.getString("Price"));
                            products.setPrfile_link(jsonObject.getString("Profile Link"));
                            products.setImage_link(jsonObject.getString("Image Link"));

                            istproductEbay.add(products);



                        }

                        for ( int i=0;i<ShirtArrayAliExpress.length();i++)
                        {
                            JSONObject jsonObjecta = ShirtArrayAliExpress.getJSONObject(i);
                            System.out.println("Ali express: "+jsonObjecta);

                            Products product = new Products();

                            product.setProduct_name(jsonObjecta.getString("Product name"));

                            product.setPrice(jsonObjecta.getString("Price"));
                            product.setPrfile_link(jsonObjecta.getString("Profile Link"));
                            product.setImage_link(jsonObjecta.getString("Image Link"));

                            istproductsAliExpress.add(product);
                        }

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }



                    setuprecyclerviewAliExpress(istproductsAliExpress);
                    setuprecyclerview(istproductEbay);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(Main2Activity.this);
            requestQueue.add(request) ;


        }

    }



    private void setuprecyclerview(List<Products> istproductsEbay) {


        RecyclerViewAdaptorEbay myadapter = new RecyclerViewAdaptorEbay(this,istproductsEbay) ;

        recycler_view_Ebay.setLayoutManager(new LinearLayoutManager(this));

        recycler_view_Ebay.setAdapter(myadapter);


    }
    private void setuprecyclerviewAliExpress(List<Products> ali_express_products) {



        RecyclerViewAdaptorAliExpress myadapter=new RecyclerViewAdaptorAliExpress(this,ali_express_products);

        recycler_view_ali_express.setLayoutManager(new LinearLayoutManager(this));

        recycler_view_ali_express.setAdapter(myadapter);

    }


}


