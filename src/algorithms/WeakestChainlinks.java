package algorithms;

public class WeakestChainlinks {

	public static void main(String[] args) {
		WeakestChainlinks weekChainlinks = new WeakestChainlinks();
		System.out.println(weekChainlinks.calculateMinimumPairSum(new int[] { 5, 2, 4, 6, 3, 7 }, 1));

	}

	public int calculateMinimumPairSum(int[] A, int requiredGapBetweenPairs) {

		if (A.length == 5) {
			return A[1] + A[3];
		}

		WeakestChainlinkPairFinder weakestChainlinkPairFinder = new WeakestChainlinkPairFinder(requiredGapBetweenPairs); 
		int i = 0;
		int j = A.length - 3;
		do {
			if (i <= A.length - 5) {
				weakestChainlinkPairFinder.visitChainlinkUpward(i, A[i + 1]);
			}
			if (j >= 2) {
				weakestChainlinkPairFinder.visitChainlinkDownward(j, A[j + 1]);
			}
			i++;
			j--;
		} while (i < A.length - 3);

		return weakestChainlinkPairFinder.calculateMinimumPairSum();
	}

		class ChainlinkStrength {
		private int position;
		private int strength;

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}
	}

	class WeakestChainlinkPairFinder {
		private final ChainlinkStrengthCircularStack minimumsEncounteredUpward;
		private final ChainlinkStrengthCircularStack minimumsEncounteredDownward;
		private final int requiredGapBetweenPairs;

		
		class ChainlinkStrengthCircularStack extends CircularLinkedStack<ChainlinkStrength> {
			public ChainlinkStrengthCircularStack(int maxDepth) {
				super(maxDepth);
			}

			public void push(int position, int strength) {
				ChainlinkStrength retval = this.nextCircularValueObject();
				retval.setPosition(position);
				retval.setStrength(strength);
			}

			@Override
			public ChainlinkStrength newCircularValueObject() {
				return new ChainlinkStrength();
			}
		}

		
		public WeakestChainlinkPairFinder(int requiredGapBetweenPairs) {

			this.requiredGapBetweenPairs = requiredGapBetweenPairs;
			this.minimumsEncounteredUpward = new ChainlinkStrengthCircularStack(requiredGapBetweenPairs + 2);
			this.minimumsEncounteredDownward = new ChainlinkStrengthCircularStack(requiredGapBetweenPairs + 2);
			
		}
		private void pushChainLinkToStack(int position, int strength, ChainlinkStrengthCircularStack whichStack) {
			if (whichStack.peek() == null || strength < whichStack.peek().getStrength()) {
				whichStack.push(position, strength);
			}
		}

		public void visitChainlinkUpward(int position, int strength) {
			this.pushChainLinkToStack(position, strength, this.minimumsEncounteredUpward);
		}

		public void visitChainlinkDownward(int position, int strength) {
			this.pushChainLinkToStack(position, strength, this.minimumsEncounteredDownward);
		}

		public int calculateMinimumPairSum() {
			if (minimumsEncounteredUpward.peek() == null || minimumsEncounteredDownward.peek() == null) {
				throw new NullPointerException(
						"this shouldn't happen.. were we called before the traversals were performed?");
			}

			int retval = minimumsEncounteredUpward.oldest().getStrength()
					+ minimumsEncounteredDownward.oldest().getStrength(); 

			ChainlinkStrength leftMinimum = minimumsEncounteredUpward.peek();
			while (leftMinimum != null) {
				ChainlinkStrength rightMinimum = minimumsEncounteredDownward.peek();
				while (rightMinimum != null) {
					if (rightMinimum.getPosition() - leftMinimum.getPosition() >= 1 + this.requiredGapBetweenPairs) { 
						retval = Math.min(retval, leftMinimum.getStrength() + rightMinimum.getStrength());
					}
					rightMinimum = minimumsEncounteredDownward.pushedBefore(rightMinimum);
				}
				leftMinimum = minimumsEncounteredUpward.pop();
			}

			return retval;
		}

	}

	
	public abstract class CircularLinkedStack<T> {

		
		private class CircularLinkedNode<T> { 
			
			private T payload;
			private CircularLinkedNode<T> previous;

			public CircularLinkedNode(T payload) {
				this.payload = payload;
			}

			public T getPayload() {
				return this.payload;
			}

			public CircularLinkedNode<T> getPrevious() {
				return this.previous;
			}

			public void setPrevious(CircularLinkedNode<T> newPrevious) {
				this.previous = newPrevious;
			}

			public void clearPrevious() {
				this.setPrevious(null);
			}
		}

		private int maxDepth;
		private CircularLinkedNode<T> top;

		
		public CircularLinkedStack(int maxDepth) {
			this.maxDepth = maxDepth;
		}

		public T peek() {
			if (this.top == null)
				return null;
			return this.top.getPayload();
		}

		public T pop() {
			CircularLinkedNode<T> previouslyLast = this.top;
			if (previouslyLast == null)
				return null;

			T payload = top.getPayload();
			this.top = top.getPrevious();
			if (this.top != null)
				top.clearPrevious();

			return payload;
		}

		public T pushedBefore(T beforeWhich) {
			CircularLinkedNode<T> lastNode = this.top;
			if (lastNode == null)
				return null;

			while (lastNode != null) {
				if (lastNode.getPayload() == beforeWhich && lastNode.getPrevious() != null) {
					
					return lastNode.getPrevious().getPayload();
				}
				lastNode = lastNode.getPrevious();
			}
			return null;
		}

		public T oldest() {
			CircularLinkedNode<T> oldestNode = this.top;
			if (oldestNode == null)
				return null;

			while (oldestNode.getPrevious() != null) {
				oldestNode = oldestNode.getPrevious();
			}
			return oldestNode.getPayload();
		}

		
		private CircularLinkedNode<T> peekBackBy(int byHowMany) {
			CircularLinkedNode<T> retval = this.top;
			for (int i = 0; i < byHowMany && retval != null; i++) {
				retval = retval.getPrevious();
			}
			return retval;
		}

		
		public T nextCircularValueObject() {
			CircularLinkedNode<T> previousTop = this.top;
			CircularLinkedNode<T> soughtNode;
			CircularLinkedNode<T> oneBeforeMax = this.peekBackBy(this.maxDepth - 1);
			if (oneBeforeMax == null || oneBeforeMax.getPrevious() == null) {
				soughtNode = new CircularLinkedNode<>(this.newCircularValueObject());
			} else {
				soughtNode = oneBeforeMax.getPrevious();
				oneBeforeMax.clearPrevious();
			}
			this.top = soughtNode;
			soughtNode.setPrevious(previousTop);
			return soughtNode.getPayload();
		}

		
		public abstract T newCircularValueObject();

	}

}
