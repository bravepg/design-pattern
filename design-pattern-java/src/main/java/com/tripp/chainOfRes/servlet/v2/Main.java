package com.tripp.chainOfRes.servlet.v2;

import java.util.ArrayList;
import java.util.List;

class Request {
    String string;
}

class Response {
    String string;
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.string = request.string.replaceAll("<", "[").replaceAll(">", "]") + " HTMLFilter()";
        filterChain.doFilter(request, response);
        response.string = response.string + " --- HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.string = request.string.replaceAll("996", "995") + " SensitiveFilter()";
        filterChain.doFilter(request, response);
        response.string = response.string + " --- SensitiveFilter()";
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }

        Filter filter = filters.get(index);

        index++;

        filter.doFilter(request, response, this);
    }
}

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.string = "<996>";
        Response response = new Response();
        response.string = "response:";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

        filterChain.doFilter(request, response);

        System.out.println(request.string);
        System.out.println(response.string);
    }
}
