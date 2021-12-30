package com.tripp.chainOfRes.servlet.v1;

import java.util.ArrayList;
import java.util.List;

class Request {
    String string;
}

class Response {
    String string;
}

interface Filter {
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.string = request.string.replaceAll("<", "[").replaceAll(">", "]");
        response.string = response.string + " --- HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.string = request.string.replaceAll("996", "995");
        response.string = response.string + " --- SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter filter: filters) {
            filter.doFilter(request, response);
        }
        return true;
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
