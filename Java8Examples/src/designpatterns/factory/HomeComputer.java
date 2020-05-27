package designpatterns.factory;

import java.util.Optional;

import designpatterns.factory.ComputerSpecs.ComputerSpecsBuilder;



/**
 * The computer implementation of the model {@link ComputerModel#HOME}.
 *
 * @author John Psoroulas
 */
public class HomeComputer extends Computer {

	public HomeComputer() {
		super(ComputerSpecsBuilder.buildStandardSpec());
	}

	public HomeComputer(ComputerSpecs spec) {
		super(Optional.ofNullable(spec)
				.orElseGet(ComputerSpecsBuilder::buildStandardSpec));
	}

}