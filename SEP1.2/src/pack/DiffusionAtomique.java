package pack;

public class DiffusionAtomique implements AlgoDiffusion{
	
	private Subject subject;
	@Override
	public void configure() {
		
	}
	@Override
	public void execute(Observer obs) {
		
		System.out.println("execute de diffAtomique");
		obs.update(subject);
		
	}
	@Override
	public void assoc(Subject s) {
		subject = s;
		System.out.println("assoc de diffAtomique");
	}
}
