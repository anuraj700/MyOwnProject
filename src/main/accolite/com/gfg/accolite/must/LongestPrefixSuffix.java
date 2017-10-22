
package com.gfg.accolite.must;

import java.util.Scanner;

public class LongestPrefixSuffix {

	public static void main(String[] args) {

		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			String str = in.next();
			int len = str.length();
			int plen = 0;
			int slen = 1;
			int cnt = 0;
			boolean var = false;
			for (plen = 0; plen < len - 1; plen++) {
				if ( !var)
					plen = 0;
				if (str.charAt(plen) == str.charAt(slen)) {
					cnt++;
					var = true;
				} else {
					var = false;
					plen = 0;
					cnt = 0;
					if (str.charAt(0) == str.charAt(slen)) {
						slen = slen - 1;
					}
				}
				slen = slen + 1;
				if (slen >= len)
					break;
			}
			if (cnt == 0) {
				if (str.charAt(0) == str.charAt(len - 1))
					cnt = 1;
			}
			System.out.println(cnt);
			t--;
		}
		in.close();
	}
}
/*
3
yuywyuwyujyuywyy
cy
luulufluulluulufluu
*/
