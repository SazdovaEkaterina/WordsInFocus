<template>
    <div class="container">
        <div class="split left">
            <div class="top">
                <h1 class="letter">{{ letter }} </h1>
            </div>
            <div class="bottom">
                
            </div>
        </div>
        <div class="split right">
            
        </div>
    </div>
</template>

<script>
    export default{
        name: "LettersComponent",
        data() {
            return {
                letter: this.$route.params.l,
                words:  "ji"
            }
        },
        methods: {
            async getWords(){
                
            }
        }
    }
</script>

<style scoped>
.container {
    height: 80vh;
}

.letter{
    background-color: whitesmoke;
    display: inline-block;
    width: 80px;
    padding: 50px;
    margin-top: 98px;
    font-size:xx-large;
    font-family: cursive;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
}
.left {

  display: block;
  float: left;
  width: 30%;
  height: 100%;
}

.right {
    display: block;
  background-color: #22a30b;
  float: left;
  width: 70%;
  height: 100%;
}

.top{
    height: 50%;
    width: 100%;
    
}

.bottom{
    height: 50%;
    background-color: pink;
}

</style>