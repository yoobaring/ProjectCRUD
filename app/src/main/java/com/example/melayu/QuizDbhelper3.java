package com.example.melayu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.melayu.QuizContract.*;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.melayu.QuizContract.QuestionsTable.COLUMN_OPTION4;

public class QuizDbhelper3 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 9;

    private SQLiteDatabase db;

    public QuizDbhelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("ขอโทษนะครับ เมื่อกี้ผมไม่ได้ยินชื่อของคุณครับ","Maaf, saya tak dengar nama awak","Perkataan demi perkataan","Sekali lagi","Jumpa awak nanti",1);
        addQuestion(q1);
        Question q2 = new Question("Terima kasih","ยินดีตอนรับครับ","คุณพูดภาษาอังกฤษได้ไหมครับ","ขอบคุณครับ ", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion(q2);
        Question q3 = new Question( "ขอให้หายเร็วๆ นะครับ","Maafkan saya","Semoga awak diberkati","Tidak", "Gembira dapat berjumpa awak", 2);
        addQuestion(q3);
        Question q4 = new Question("ผมมาจากนิวยอร์กครับ", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi", "Saya dari New York", 4);
        addQuestion(q4);
        Question q5 = new Question("Gembira bertemu dengan awak", "คุณพูดว่าอะไรน่ะครับ","ยินดีที่ได้พบคุณครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion(q5);
        Question q6 = new Question("คุณชื่ออะไร", "Selamat tinggal", "Boleh saya bantu awak","Sekali lagi","Siapa nama awak", 4);
        addQuestion(q6);
        Question q7 = new Question("Selamat hari jadi", "คุณพูดว่าอะไรน่ะครับ","สุขสันต์วันเกิดนะครับ","มีอะไรให้ช่วยไหมครับ","ไปก่อนน่ะครับ", 2);
        addQuestion(q7);
        Question q8 = new Question( " Awak dari mana","มีอะไรให้ช่วยไหมครับ", "ยินดีตอนรับครับ","คุณมาจากที่ไหน", "วันนี้อากาศดีมากนะครับ", 3);
        addQuestion(q8);
        Question q9 = new Question( "Nama saya Maria", "ฉันชื่อมาเรียค่ะ ", "สวัสดีตอนเช้าครับ", "วันนี้อากาศดีมากน่ะครับ", "ขอให้โชคดีน่ะครับ", 1);
        addQuestion(q9);
        Question q10 = new Question("ได้โปรด","Boleh", "sedikit", "Silakan"," Awak ada soalan", 3);
        addQuestion(q10);

    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if ( c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
