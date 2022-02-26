package dadm.quixada.ufc.cartao_visita.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import dadm.quixada.ufc.cartao_visita.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddBusinessCardActivity extends AppCompatActivity {

    private TextInputEditText txt_nome, txt_telefone, txt_email, txt_empresa, txt_cor;
    private ImageButton button_close;
    private MaterialButton button_confirm;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business_card);

        txt_nome = findViewById(R.id.txt_nome);
        txt_telefone = findViewById(R.id.txt_telefone);
        txt_email = findViewById(R.id.txt_email);
        txt_empresa = findViewById(R.id.txt_empresa);
        txt_cor = findViewById(R.id.txt_cor);
        button_close = findViewById(R.id.btn_close);
        button_confirm = findViewById(R.id.btn_confirm);
        db = FirebaseFirestore.getInstance();

        insertListener();
    }

    private void addAllDates(){
        String id = UUID.randomUUID().toString();
        String nome = txt_nome.getText().toString();
        String telefone = txt_telefone.getText().toString();
        String email = txt_email.getText().toString();
        String empresa = txt_empresa.getText().toString();
        String cor = txt_cor.getText().toString();

        Map<String, Object> cartao = new HashMap<>();

        cartao.put("id", id);
        cartao.put("nome", nome);
        cartao.put("telefone", telefone);
        cartao.put("email", email);
        cartao.put("empresa", empresa);
        cartao.put("cor", cor);

        db.collection("Cartao").document(id).set(cartao).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AddBusinessCardActivity.this, "Cartão adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddBusinessCardActivity.this, MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddBusinessCardActivity.this, "Cartão não foi adicionado!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void insertListener(){
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAllDates();
            }
        });
    }
}