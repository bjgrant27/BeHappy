package com.bootisdev.behappy.data;

import com.bootisdev.behappy.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
