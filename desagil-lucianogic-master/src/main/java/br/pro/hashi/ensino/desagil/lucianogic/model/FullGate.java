package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xor1;
	private XorGate xor2;
	private AndGate and1;
	private AndGate and2;
	private OrGate or;
	
	public FullGate(){
		super(3, 2);

		name = "FULL";

		xor1 = new XorGate();
		xor2 = new XorGate();
		and1 = new AndGate();
		and2 = new AndGate();
		or = new OrGate();
		xor2.connect(xor1, 0);
		and1.connect(xor1, 0);
		or.connect(and1, 0);
		or.connect(and2, 1);
	}
	
	@Override
	public boolean doRead(int index) {
		if (index == 0){
			return xor2.read();
		}else{
			return or.read();
		}
	}
	
	@Override
	protected void doConnect(Emitter emitter, int index) {
		if(index==0){
			xor1.connect(emitter, 0);
			and2.connect(emitter, 0);
		}
		else if(index==1){
			xor1.connect(emitter, 1);
			and2.connect(emitter, 1);
		}else{
			xor2.connect(emitter, 1);
			and1.connect(emitter, 1);
		}
	
}

}
