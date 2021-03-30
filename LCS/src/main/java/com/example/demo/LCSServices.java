package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LCSServices {

	public Response lcs(Request list) {
		int n = list.getSetOfStrings().size();
		String s = list.getSetOfStrings().get(0).getValue();
		int len = s.length();
		String res = "";
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String stem = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++)
					if (!list.getSetOfStrings().get(k).getValue().contains(stem))
						break;
				if (k == n && res.length() < stem.length())
					res = stem;
			}
		}
		Response response = new Response();
		Value v = new Value();
		v.setValue(res);
		response.lcs =  new ArrayList();
		response.lcs.add(v);
		return response;
	}

}
