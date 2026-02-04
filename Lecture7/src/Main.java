public class Main {

    public static void buildTree(Map<String,String> list){
        list.put("Fardi","12345");
        list.put("Brandefelt","08158611");
        list.put("Amri","54321");
        list.put("Olsson","222222");
        list.put("Tuiskunen","33333333");
        list.put("Scott","44444444");
        list.put("Abbi","7777777");
	}
	public static void main(String[] args) {

		Map<String,String> phoneList= new Map<>();
		buildTree(phoneList);
		System.out.println(phoneList);
        System.out.println(phoneList.remove("Tuiskunen"));
	}
}
