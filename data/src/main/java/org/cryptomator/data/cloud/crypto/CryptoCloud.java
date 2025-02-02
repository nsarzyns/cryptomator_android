package org.cryptomator.data.cloud.crypto;

import org.cryptomator.domain.Cloud;
import org.cryptomator.domain.CloudType;
import org.cryptomator.domain.Vault;

public class CryptoCloud implements Cloud {

	private final Vault vault;

	CryptoCloud(Vault vault) {
		this.vault = vault;
	}

	@Override
	public Long id() {
		return null;
	}

	@Override
	public CloudType type() {
		return CloudType.CRYPTO;
	}

	@Override
	public boolean configurationMatches(Cloud cloud) {
		return cloud instanceof CryptoCloud && configurationMatches((CryptoCloud) cloud);
	}

	private boolean configurationMatches(CryptoCloud cloud) {
		return vault.equals(cloud.vault);
	}

	@Override
	public boolean persistent() {
		return false;
	}

	@Override
	public boolean requiresNetwork() {
		return false;
	}

	public Vault getVault() {
		return vault;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		return internalEquals((CryptoCloud) obj);
	}

	@Override
	public int hashCode() {
		return vault.hashCode();
	}

	private boolean internalEquals(CryptoCloud obj) {
		return vault != null && vault.equals(obj.vault);
	}

}
