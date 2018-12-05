package silantyevmn.ru.developerinterview.lesson4;


import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import silantyevmn.ru.developerinterview.R;

public class MyWidget extends AppWidgetProvider {

    private final static String ExtraMsg = "msg";
    private static final String TAG = "widget_life_cycle";
    private static final String ACTION = "ActionReceiverWidget";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget);
        // Здесь обновим текст, будем показывать номер виджета
        views.setTextViewText(R.id.appwidget_text, String.format("%s - %d", widgetText, appWidgetId));

        Intent active = new Intent(context, MyWidget.class);
        active.setAction(ACTION);
        active.putExtra(ExtraMsg, "KEK");

        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        views.setOnClickPendingIntent(R.id.appwidget_btn, actionPendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.i(TAG, "onUpdate");
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDisabled(Context context) {
        Log.i(TAG, "onDisabled");
        super.onDisabled(context);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.i(TAG, "onDeleted");
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        Log.i(TAG, "onEnabled");
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        final String action = intent.getAction();

        if (ACTION.equals(action))
            try {
                Log.i("widget_receive", intent.getStringExtra(ExtraMsg));
            } catch (NullPointerException e) {
            }
        super.onReceive(context, intent);
    }
}


