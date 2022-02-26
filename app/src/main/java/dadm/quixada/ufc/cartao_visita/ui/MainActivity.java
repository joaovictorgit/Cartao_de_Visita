package dadm.quixada.ufc.cartao_visita.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import dadm.quixada.ufc.cartao_visita.Adapter.BusinessAdapter;
import dadm.quixada.ufc.cartao_visita.R;
import dadm.quixada.ufc.cartao_visita.data.BusinessCard;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton button;
    FirebaseFirestore db;
    ArrayList<BusinessCard> listBusiness;
    BusinessAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        button = findViewById(R.id.fab);
        listBusiness = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        insertListener();
        exibir();
    }

    private void exibir(){
        db.collection("Cartao").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                listBusiness.clear();
                for(DocumentSnapshot documentSnapshot: task.getResult()){
                    BusinessCard b = new BusinessCard(
                            documentSnapshot.getString("id"),
                            documentSnapshot.getString("nome"),
                            documentSnapshot.getString("telefone"),
                            documentSnapshot.getString("email"),
                            documentSnapshot.getString("empresa"),
                            documentSnapshot.getString("cor")
                    );
                    listBusiness.add(b);
                }
                adapter = new BusinessAdapter(MainActivity.this, listBusiness);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private void insertListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBusinessCardActivity.class);
                startActivity(intent);
            }
        });
    }
}