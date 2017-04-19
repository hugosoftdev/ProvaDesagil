package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xor;
	private AndGate and;

	public HalfGate() {
		super(2, 2);

		name = "HALF";

		xor = new XorGate();
		and = new AndGate();
		
	}
	@Override
	public boolean doRead(int index) {
		if (index == 0){
			return xor.read();
		}else{
			return and.read();
		}
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if (index==0){
			xor.connect(emitter, 0);
			and.connect(emitter, 0);
		}else{
			xor.connect(emitter, 1);
			and.connect(emitter, 1);
		}
}
	
}
