package main.java.hummel;

public class Room {
	public String color;
	public String glowing;
	public String direct;
	public String environment;
	public RoomType rtype;
	public WindowType wtype;

	public Room(String fcolor, String fglowing, String fdirect, String fenvironment, RoomType frtype, WindowType fwtype) {
		color = fcolor;
		glowing = fglowing;
		direct = fdirect;
		environment = fenvironment;
		rtype = frtype;
		wtype = fwtype;
	}

	public enum RoomType {
		OTSEK("otsek"), ROOM("room"), CORRIDOR("corridor");

		public String name;
		RoomType(String fName) {
			name = fName;
		}

		public static RoomType forName(String search) {
			for (RoomType r : RoomType.values()) {
				if (search.equals(r.name)) {
					return r;
				}
			}
			return null;
		}
	}

	public enum WindowType {
		BIG("big"), SMALL("small"), NONE("none");

		public String name;
		WindowType(String fName) {
			name = fName;
		}

		public static WindowType forName(String search) {
			for (WindowType r : WindowType.values()) {
				if (search.equals(r.name)) {
					return r;
				}
			}
			return null;
		}
	}
}
