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

		public String eName;
		RoomType(String fName) {
			eName = fName;
		}

		public static RoomType forName(String search) {
			for (RoomType r : RoomType.values()) {
				if (search.equals(r.eName)) {
					return r;
				}
			}
			return null;
		}
	}

	public enum WindowType {
		BIG("big"), SMALL("small"), NONE("none");

		public String eName;
		WindowType(String fName) {
			eName = fName;
		}

		public static WindowType forName(String search) {
			for (WindowType r : WindowType.values()) {
				if (search.equals(r.eName)) {
					return r;
				}
			}
			return null;
		}
	}
}
