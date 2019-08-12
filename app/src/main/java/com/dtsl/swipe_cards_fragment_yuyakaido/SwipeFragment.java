package com.dtsl.swipe_cards_fragment_yuyakaido;

import android.content.Context;
import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dtsl.swipe_cards_fragment_yuyakaido.dummy.DummyContent;
import com.yuyakaido.android.cardstackview.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SwipeFragment extends Fragment implements CardStackListener{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private CardStackView cardStackView;
    private CardStackLayoutManager cardStackLayoutManager;
    private UserAdapter userAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SwipeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SwipeFragment newInstance(int columnCount) {
        SwipeFragment fragment = new SwipeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        this.cardStackView = view.findViewById(R.id.card_stack_view);
        this.cardStackLayoutManager = new CardStackLayoutManager(getContext());

        this.userAdapter=new UserAdapter(this.GetUsers());

        this.cardStackLayoutManager.setStackFrom(StackFrom.Top);
        this.cardStackLayoutManager.setVisibleCount(3);
        this.cardStackLayoutManager.setDirections(Direction.FREEDOM);

        this.cardStackView.setLayoutManager(this.cardStackLayoutManager);
        this.cardStackView.setAdapter(this.userAdapter);

        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private  List<DummyContent> GetUsers(){
        ArrayList<DummyContent> list = new ArrayList<>();
        list.add(new DummyContent("Brittany", "24"));
        list.add(new DummyContent("Paco", "30"));
        list.add(new DummyContent("Roberto", "30"));
        list.add(new DummyContent("Rodrigo", "30"));
        list.add(new DummyContent("Carlos", "30"));
        return  list;
    }




    @Override
    public void onCardDragging(Direction direction, float ratio) {
        Log.d("dragging to :", direction.name());

    }

    @Override
    public void onCardSwiped(Direction direction) {
        Log.d("swiped to :", direction.name());
    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyContent item);
    }
}
