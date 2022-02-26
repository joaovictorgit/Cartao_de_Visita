package dadm.quixada.ufc.cartao_visita.Holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import dadm.quixada.ufc.cartao_visita.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public MaterialTextView txt_nome, txt_telefone, txt_email, txt_empresa;
    View view;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

        txt_nome = view.findViewById(R.id.tv_nome);
        txt_telefone = view.findViewById(R.id.tv_telefone);
        txt_email = view.findViewById(R.id.tv_email);
        txt_empresa = view.findViewById(R.id.tv_nome_empresa);

    }

    private ClickListener mClickListener;

    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
