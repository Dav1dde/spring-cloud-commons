package org.springframework.cloud.client.loadbalancer.impl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancer;
import org.springframework.cloud.client.loadbalancer.impl.scoped.ScopedLoadBalancer;
import org.springframework.cloud.client.loadbalancer.impl.support.LoadBalancerClientFactory;

/**
 * @author Spencer Gibb
 */
public class CommonsLoadBalancer implements LoadBalancer {

	private final LoadBalancerClientFactory clientFactory;

	public CommonsLoadBalancer(LoadBalancerClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public ServiceInstance choose(String serviceId) {
		ScopedLoadBalancer scopedLoadBalancer = this.clientFactory.getInstance(serviceId, ScopedLoadBalancer.class);

		return scopedLoadBalancer.choose();
	}

	public LoadBalancerClientFactory getClientFactory() {
		return clientFactory;
	}
}
