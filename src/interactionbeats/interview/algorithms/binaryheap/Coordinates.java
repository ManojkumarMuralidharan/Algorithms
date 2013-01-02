package interactionbeats.interview.algorithms.binaryheap;

	class Coordinates implements Comparable<Coordinates>{
		int x;
		int y;
		public Coordinates(int x, int y) {
			this.x=x;
			this.y=y;
			// TODO Auto-generated constructor stub
		}
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		public int getDistance(){
			return (x*x + y*y );
		}
		public void setX(int x){
			this.x=x;
		}
		public void setY(int y){
			this.y=y;
		}
		@Override
		public int compareTo(Coordinates o) {
			// TODO Auto-generated method stub
			if(getDistance()<o.getDistance()){
				return -1;
			}else if(getDistance()>o.getDistance()){
				return 1;
			}
			return 0;
		}
	}