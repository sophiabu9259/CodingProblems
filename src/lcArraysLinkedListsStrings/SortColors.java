package lcArraysLinkedListsStrings;

public class SortColors {
	public void sortColors ( int[] colors) {
		int[] base = new int[3];
		int[] result = new int[colors.length];
		for (int e : colors) {
			base[e]++;
		}
		for (int i = 1; i < base.length; i++) {
			base[i] += base[i-1];
		}
		for (int e:colors) {
			result[base[e]-1] = e;
			base[e]--;
		}
		for (int i = 0; i < colors.length; i++) {
			colors[i] = result[i];
		}	
	}
	
	public void sortColorsOnePass (int[] colors) {
		int p = 0;
		int q = colors.length -1;
		int index = 0;
		while (index < q) {
			while (colors[index] == 0 && index > p) {
				colors[index] = colors[p];
				colors[p++] = 0;
			}
			while (colors[index] == 2 && index  < q) {
				colors[index] = colors[q];
				colors[q--] = 2;
			}
			index++;
		}
	}
}
