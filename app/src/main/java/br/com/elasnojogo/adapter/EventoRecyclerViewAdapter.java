package br.com.elasnojogo.adapter;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.EventListener;
import java.util.List;

import br.com.elasnojogo.Interface.EventoListener;
import br.com.elasnojogo.Model.DadosEvento;
import br.com.elasnojogo2.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class EventoRecyclerViewAdapter extends RecyclerView.Adapter<EventoRecyclerViewAdapter.ViewHolder> {

    private List<DadosEvento> eventos;

    private EventoListener listener;

    public EventoRecyclerViewAdapter(List<DadosEvento> listaEventos, EventoListener listener) {
        this.eventos = listaEventos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eventos_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DadosEvento dadosEvento = eventos.get(position);

        holder.onBind(dadosEvento);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.enviaEvento(dadosEvento);
            }
        });
    }

    @Override
    public int getItemCount() { return eventos.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView image;
        private TextView nomeEvento;
        private TextView localEvento;
        private TextView dataEvento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.circleImageView);
            nomeEvento = itemView.findViewById(R.id.text_view_nomeevento);
            localEvento = itemView.findViewById(R.id.text_view_local);
            dataEvento = itemView.findViewById(R.id.text_view_data);
        }

        public void onBind(DadosEvento dadosEvento) {
            image.setImageResource(R.drawable.contraataque_post_mulheres_esporte_01_ls);
            nomeEvento.setText(dadosEvento.getNomeEvento());
            localEvento.setText(dadosEvento.getLocalEvento());
            dataEvento.setText(dadosEvento.getDataEvento());
        }
    }
}
