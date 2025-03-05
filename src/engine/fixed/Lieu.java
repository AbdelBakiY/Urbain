package engine.fixed;

public abstract class Lieu {
	
	private String name;
	private String imgPath;
	private String id;
    private Position position; // Ajoutez un attribut de type Position

	
	public Lieu(String name,String imgPath,String id) {
		this.imgPath=imgPath;
		this.name=name;
		this.id=id;
		
	}
	public Lieu(String name) {
		this.name=name;
		
	}
	public Lieu(String name, Position position) {
        this.name = name;
        this.position = position;
    }
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
	@Override
	public String toString() {
		return "Lieu [name=" + name + ", imgPath=" + imgPath + ", id=" + id + ", position=" + position.toString() + "]";
	}
	
	

}
