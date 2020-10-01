package basket;

public class Pair<L,R> {
    private L item;
    private R amount;
    public Pair(L l, R r){
        this.item = l;
        this.amount = r;
    }
    public L getItem(){ return item; }
    public R getAmount(){ return amount; }
    public void setItem(L l){ this.item = l; }
    public void setAmount(R r){ this.amount = r; }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
    
}