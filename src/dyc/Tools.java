package dyc;

public class Tools {
	public static void quicksort(int[] num) {
		quicksortRecusion(num, 0, num.length - 1);
	}

	public static void quicksortRecusion(int[] num, int l, int r) {
		if (l >= r) {
			return;
		}
		int pivot = num[l];
		int iless = l, icurrent;
		for (icurrent = l + 1; icurrent <= r; ++icurrent) {
			if (num[icurrent] < pivot) {
				int temp = num[iless + 1];
				num[iless + 1] = num[icurrent];
				num[icurrent] = temp;
				++iless;
			}
		}
		num[l] = num[iless];
		num[iless] = pivot;
		quicksortRecusion(num, l, iless - 1);
		quicksortRecusion(num, iless + 1, r);
	}
	
	public static void dumpArray(int[] num){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i]);
			sb.append(",");
		}
		sb.setCharAt(sb.length()-1, '}');
	}

	public static void main(String[] args) {
		quicksort(new int[] { 8, 1, 4, 2, 3, 9 });
	}

}
