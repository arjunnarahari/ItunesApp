package app.itunes.play.presentation.viewmodel.events;

public interface EventHandler<V> {
    void onEventUnHandled(V object);
}