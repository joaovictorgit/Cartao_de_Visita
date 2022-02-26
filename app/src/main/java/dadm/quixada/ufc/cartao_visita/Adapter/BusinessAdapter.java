package dadm.quixada.ufc.cartao_visita.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dadm.quixada.ufc.cartao_visita.Holder.ViewHolder;
import dadm.quixada.ufc.cartao_visita.R;
import dadm.quixada.ufc.cartao_visita.data.BusinessCard;
import dadm.quixada.ufc.cartao_visita.ui.MainActivity;

public class BusinessAdapter extends RecyclerView.Adapter<ViewHolder> {

    ArrayList<BusinessCard> listBusiness;
    MainActivity listActivity;

    public BusinessAdapter(MainActivity listActivity, ArrayList<BusinessCard> listBusiness) {
        this.listActivity = listActivity;
        this.listBusiness = listBusiness;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_business_card, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String nome = listBusiness.get(position).getNome();
                String telefone = listBusiness.get(position).getTelefone();
                String email = listBusiness.get(position).getEmail();
                String empresa = listBusiness.get(position).getEmpresa();
                String cor = listBusiness.get(position).getFundoPersonalizado();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        holder.txt_nome.setText(listBusiness.get(position).getNome());
        holder.txt_telefone.setText(listBusiness.get(position).getTelefone());
        holder.txt_email.setText(listBusiness.get(position).getEmail());
        holder.txt_empresa.setText(listBusiness.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return listBusiness.size();
    }
}
